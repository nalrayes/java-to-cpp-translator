#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test019 {
  
    struct __A;
    struct __A_VT;
    typedef __rt::Ptr<__A> A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

      int32_t x;

      static A __init(A __this);
      static Class __class();

      static __A_VT __vtable;
    };

    struct __A_VT { 
      Class __is_a;

      void (*__delete) (__A*);
      int32_t (*hashCode) (A);
      bool (*equals) (A, Object);
      Class (*getClass) (A);
      String (*toString) (A);

      __A_VT()
      : __is_a(__A::__class()),
        __delete(__rt::__delete<__A>),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        equals((bool (*)(A, Object)) &__Object::equals),
        getClass((Class (*)(A)) &__Object::getClass),
        toString((String (*)(A)) &__Object::toString) {}
    };

    struct __Test019;
    struct __Test019_VT;
    typedef __rt::Ptr<__Test019> Test019;
    
    struct __Test019 { 
      
      __Test019_VT* __vptr;
      
      __Test019();

      static void main_String(Test019, String);
      static Test019 __init(Test019 __this);
      static Class __class();

      static __Test019_VT __vtable;
    };

    struct __Test019_VT { 
      Class __is_a;

      void (*__delete) (__Test019*);
      int32_t (*hashCode) (Test019);
      bool (*equals) (Test019, Object);
      Class (*getClass) (Test019);
      String (*toString) (Test019);
      void (*main_String) (Test019, String);

      __Test019_VT()
      : __is_a(__Test019::__class()),
        __delete(__rt::__delete<__Test019>),
        hashCode((int32_t (*)(Test019)) &__Object::hashCode),
        equals((bool (*)(Test019, Object)) &__Object::equals),
        getClass((Class (*)(Test019)) &__Object::getClass),
        toString((String (*)(Test019)) &__Object::toString),
        main_String(&__Test019::main_String) {}
    };

  }
}
