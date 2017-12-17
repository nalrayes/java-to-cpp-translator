#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test000 {
  
    struct __Test000;
    struct __Test000_VT;
    typedef __rt::Ptr<__Test000> Test000;
    
    struct __Test000 { 
      
      __Test000_VT* __vptr;
      
      __Test000();

      static void main_String(Test000,String);
      static Test000 __init(Test000 __this);
      static Class __class();

      static __Test000_VT __vtable;
    };

    struct __Test000_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test000);
      Class (*getClass) (Test000);
      String (*toString) (Test000);
      bool (*equals) (Test000, Object);
      void (*__delete) (__Test000*);
      void (*main_String) (Test000, String);

      __Test000_VT()
      : __is_a(__Test000::__class()),
        hashCode((int32_t (*)(Test000)) &__Object::hashCode),
        getClass((Class (*)(Test000)) &__Object::getClass),
        toString((String (*)(Test000)) &__Object::toString),
        equals((bool (*)(Test000, Object)) &__Object::equals),
        __delete(__rt::__delete<__Test000>),
        main_String(&__Test000::main_String) {}
    };

  }
}
