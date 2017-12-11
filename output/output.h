#pragma once
#include "java_lang.h"
#include <string>
#include "output.h"
#include <iostream>

using namespace java::lang;

namespace inputs {
  namespace test017 {
  
    struct __A;
    struct __A_VT;
    typedef __A* A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

      A self;

      static A self(A);
      static A __init(int32_t);
      static Class __class();

      static __A_VT __vtable;
    };

    struct __A_VT { 
      Class __is_a;

      int32_t (*hashCode) (A);
      Class (*getClass) (A);
      String (*toString) (A);
      bool (*equals) (A, Object);
      A (*self) (A);

      __A_VT()
      : __is_a(__A::__class()),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        getClass((Class (*)(A)) &__Object::getClass),
        toString((String (*)(A)) &__Object::toString),
        equals((bool (*)(A, Object)) &__Object::equals),
        self(&__A::self) {}
    };

    struct __Test017;
    struct __Test017_VT;
    typedef __Test017* Test017;
    
    struct __Test017 { 
      
      __Test017_VT* __vptr;
      
      __Test017();

      static void main_String(Test017,String);
      static Test017 __init();
      static Class __class();

      static __Test017_VT __vtable;
    };

    struct __Test017_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test017);
      Class (*getClass) (Test017);
      String (*toString) (Test017);
      bool (*equals) (Test017, Object);

      __Test017_VT()
      : __is_a(__Test017::__class()),
        hashCode((int32_t (*)(Test017)) &__Object::hashCode),
        getClass((Class (*)(Test017)) &__Object::getClass),
        toString((String (*)(Test017)) &__Object::toString),
        equals((bool (*)(Test017, Object)) &__Object::equals),
        main_String(&__Test017::main_String) {}
    };

  }
}
