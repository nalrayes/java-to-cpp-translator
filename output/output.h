#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test008 {
  
    struct __A;
    struct __A_VT;
    typedef __A* A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

      String a;

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

    struct __B;
    struct __B_VT;
    typedef __B* B;
    
    struct __B { 
      
      __B_VT* __vptr;
      
      __B();

      String b;

      static B __init();
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

    struct __Test008;
    struct __Test008_VT;
    typedef __Test008* Test008;
    
    struct __Test008 { 
      
      __Test008_VT* __vptr;
      
      __Test008();

      static void main_String(Test008,String);
      static Test008 __init();
      static Class __class();

      static __Test008_VT __vtable;
    };

    struct __Test008_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test008);
      Class (*getClass) (Test008);
      String (*toString) (Test008);
      bool (*equals) (Test008, Object);

      __Test008_VT()
      : __is_a(__Test008::__class()),
        hashCode((int32_t (*)(Test008)) &__Object::hashCode),
        getClass((Class (*)(Test008)) &__Object::getClass),
        toString((String (*)(Test008)) &__Object::toString),
        equals((bool (*)(Test008, Object)) &__Object::equals),
        main_String(&__Test008::main_String) {}
    };

  }
}
