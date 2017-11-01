#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test007 {
  
    struct __A;
    struct __A_VT;
    typedef __A* A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

      static A __init();
      String a;

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

    struct __B;
    struct __B_VT;
    typedef __B* B;
    
    struct __B { 
      
      __B_VT* __vptr;
      
      __B();

      static B __init();
      String b;

      static Class __class();

      static __B_VT __vtable;
    };

    struct __B_VT { 
      Class __is_a;

      int32_t (*hashCode) (B);
      Class (*getClass) (B);
      String (*toString) (B);
      bool (*equals) (B, Object);

      __B_VT()
      : __is_a(__B::__class()),
        hashCode((int32_t (*)(B)) &__Object::hashCode),
        getClass((Class (*)(B)) &__Object::getClass),
        toString((String (*)(B)) &__Object::toString),
        equals((bool (*)(B, Object)) &__Object::equals) {}
    };

    struct __Test007;
    struct __Test007_VT;
    typedef __Test007* Test007;
    
    struct __Test007 { 
      
      __Test007_VT* __vptr;
      
      __Test007();

      static void main(Test007,String);
      static Test007 __init();
      static Class __class();

      static __Test007_VT __vtable;
    };

    struct __Test007_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test007);
      Class (*getClass) (Test007);
      String (*toString) (Test007);
      bool (*equals) (Test007, Object);
      void (*main) (Test007);

      __Test007_VT()
      : __is_a(__Test007::__class()),
        hashCode((int32_t (*)(Test007)) &__Object::hashCode),
        getClass((Class (*)(Test007)) &__Object::getClass),
        toString((String (*)(Test007)) &__Object::toString),
        equals((bool (*)(Test007, Object)) &__Object::equals),
        main(&__Test007::main) {}
    };

  }
}
