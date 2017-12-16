#pragma once

#include <iostream>

#if 1
#define TRACE(s) \
  std::cout << __FUNCTION__ << ":" << __LINE__ << ": " << s << std::endl;
#else
#define TRACE(s)
#endif

namespace __rt {
  
  template<typename T>
  class Ptr {
    T* addr;

  public:
    Ptr(T* addr = 0) : addr(addr) {
      TRACE("constructor");
    }

    Ptr(const Ptr& other) : addr(other.addr) {
      TRACE("copy constructor");
    }

    Ptr& operator=(const Ptr& other) {
      TRACE("assignment operator");
      if (&other != this) {
        addr = other.addr;
      }
      return *this;
    }

    ~Ptr() {
      TRACE("destructor");
    }
    
    T& operator*() const {
      TRACE("dereference operator");
      return *addr;
    }

    T* operator->() const {
      TRACE("arrow operator");
      return addr;
    }

    T* raw() { return addr; };
    
  };

}
