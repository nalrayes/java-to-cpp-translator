#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test009 {
  
    struct __A;
    struct __A_VT;
    typedef __A* A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

      public A self;

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

    struct __Test009;
    struct __Test009_VT;
    typedef __Test009* Test009;
    
    struct __Test009 { 
      
      __Test009_VT* __vptr;
      
      __Test009();

      static void main_String(Test009,String);
      static Test009 __init();
      static Class __class();

      static __Test009_VT __vtable;
    };

    struct __Test009_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test009);
      Class (*getClass) (Test009);
      String (*toString) (Test009);
      bool (*equals) (Test009, Object);

      __Test009_VT()
      : __is_a(__Test009::__class()),
        hashCode((int32_t (*)(Test009)) &__Object::hashCode),
        getClass((Class (*)(Test009)) &__Object::getClass),
        toString((String (*)(Test009)) &__Object::toString),
        equals((bool (*)(Test009, Object)) &__Object::equals),
        main_String(&__Test009::main_String) {}
    };

  }
}
