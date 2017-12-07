#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test021 {
  
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

    struct __Test021;
    struct __Test021_VT;
    typedef __Test021* Test021;
    
    struct __Test021 { 
      
      __Test021_VT* __vptr;
      
      __Test021();

      static void main_String(Test021,String);
      static Test021 __init();
      static Class __class();

      static __Test021_VT __vtable;
    };

    struct __Test021_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test021);
      Class (*getClass) (Test021);
      String (*toString) (Test021);
      bool (*equals) (Test021, Object);

      __Test021_VT()
      : __is_a(__Test021::__class()),
        hashCode((int32_t (*)(Test021)) &__Object::hashCode),
        getClass((Class (*)(Test021)) &__Object::getClass),
        toString((String (*)(Test021)) &__Object::toString),
        equals((bool (*)(Test021, Object)) &__Object::equals),
        main_String(&__Test021::main_String) {}
    };

  }
}
