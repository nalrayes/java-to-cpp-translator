#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test018 {
  
    struct __A;
    struct __A_VT;
    typedef __A* A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

      static int32_t x;

      static A __init();
      static Class __class();

      static __A_VT __vtable;
    };

    struct __A_VT { 
      Class __is_a;

      int32_t (*hashCode) (A);
      Class (*getClass) (A);
      String (*toString) (A);
      bool (*equals) (A, Object);

      __A_VT()
      : __is_a(__A::__class()),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        getClass((Class (*)(A)) &__Object::getClass),
        toString((String (*)(A)) &__Object::toString),
        equals((bool (*)(A, Object)) &__Object::equals) {}
    };

    struct __Test018;
    struct __Test018_VT;
    typedef __Test018* Test018;
    
    struct __Test018 { 
      
      __Test018_VT* __vptr;
      
      __Test018();

      static void main_String(Test018,String);
      static Test018 __init();
      static Class __class();

      static __Test018_VT __vtable;
    };

    struct __Test018_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test018);
      Class (*getClass) (Test018);
      String (*toString) (Test018);
      bool (*equals) (Test018, Object);

      __Test018_VT()
      : __is_a(__Test018::__class()),
        hashCode((int32_t (*)(Test018)) &__Object::hashCode),
        getClass((Class (*)(Test018)) &__Object::getClass),
        toString((String (*)(Test018)) &__Object::toString),
        equals((bool (*)(Test018, Object)) &__Object::equals),
        main_String(&__Test018::main_String) {}
    };

  }
}
