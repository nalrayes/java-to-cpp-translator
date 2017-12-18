#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test018 {
  
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

    struct __Test018;
    struct __Test018_VT;
    typedef __rt::Ptr<__Test018> Test018;
    
    struct __Test018 { 
      
      __Test018_VT* __vptr;
      
      __Test018();

      static void main_String(Test018, String);
      static Test018 __init(Test018 __this);
      static Class __class();

      static __Test018_VT __vtable;
    };

    struct __Test018_VT { 
      Class __is_a;

      void (*__delete) (__Test018*);
      int32_t (*hashCode) (Test018);
      bool (*equals) (Test018, Object);
      Class (*getClass) (Test018);
      String (*toString) (Test018);
      void (*main_String) (Test018, String);

      __Test018_VT()
      : __is_a(__Test018::__class()),
        __delete(__rt::__delete<__Test018>),
        hashCode((int32_t (*)(Test018)) &__Object::hashCode),
        equals((bool (*)(Test018, Object)) &__Object::equals),
        getClass((Class (*)(Test018)) &__Object::getClass),
        toString((String (*)(Test018)) &__Object::toString),
        main_String(&__Test018::main_String) {}
    };

  }
}
