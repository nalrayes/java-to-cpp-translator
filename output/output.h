#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test026 {
  
    struct __A;
    struct __A_VT;
    typedef __A* A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

      int32_t i;

      static int32_t get(A);
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
      int32_t (*get) (A);

      __A_VT()
      : __is_a(__A::__class()),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        getClass((Class (*)(A)) &__Object::getClass),
        toString((String (*)(A)) &__Object::toString),
        equals((bool (*)(A, Object)) &__Object::equals),
        get(&__A::get) {}
    };

    struct __B;
    struct __B_VT;
    typedef __B* B;
    
    struct __B { 
      
      __B_VT* __vptr;
      
      __B();

      static int32_t get(B);
      static B __init(int32_t);
      static Class __class();

      static __B_VT __vtable;
    };

    struct __B_VT { 
      Class __is_a;

      int32_t (*hashCode) (B);
      Class (*getClass) (B);
      String (*toString) (B);
      bool (*equals) (B, Object);
      int32_t (*get) (B);

      __B_VT()
      : __is_a(__B::__class()),
        hashCode((int32_t (*)(B)) &__Object::hashCode),
        getClass((Class (*)(B)) &__Object::getClass),
        toString((String (*)(B)) &__Object::toString),
        equals((bool (*)(B, Object)) &__Object::equals),
        get(&__B::get) {}
    };

    struct __Test026;
    struct __Test026_VT;
    typedef __Test026* Test026;
    
    struct __Test026 { 
      
      __Test026_VT* __vptr;
      
      __Test026();

      static void main_String(Test026,String);
      static Test026 __init();
      static Class __class();

      static __Test026_VT __vtable;
    };

    struct __Test026_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test026);
      Class (*getClass) (Test026);
      String (*toString) (Test026);
      bool (*equals) (Test026, Object);

      __Test026_VT()
      : __is_a(__Test026::__class()),
        hashCode((int32_t (*)(Test026)) &__Object::hashCode),
        getClass((Class (*)(Test026)) &__Object::getClass),
        toString((String (*)(Test026)) &__Object::toString),
        equals((bool (*)(Test026, Object)) &__Object::equals),
        main_String(&__Test026::main_String) {}
    };

  }
}
