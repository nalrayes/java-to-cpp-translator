#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test042 {
  
    struct __A;
    struct __A_VT;
    typedef __A* A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

      static void m(A);
      static A m_A(A,A);
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
      void (*m) (A);
      A (*m_A) (A, A);

      __A_VT()
      : __is_a(__A::__class()),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        getClass((Class (*)(A)) &__Object::getClass),
        toString((String (*)(A)) &__Object::toString),
        equals((bool (*)(A, Object)) &__Object::equals),
        m(&__A::m),
        m_A(&__A::m_A) {}
    };

    struct __B;
    struct __B_VT;
    typedef __B* B;
    
    struct __B { 
      
      __B_VT* __vptr;
      
      __B();

      static void m(B);
      static B m_B(B,B);
      static A m_A(B,A);
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
      void (*m) (B);
      A (*m_A) (B, A);
      B (*m_B) (B, B);

      __B_VT()
      : __is_a(__B::__class()),
        hashCode((int32_t (*)(B)) &__Object::hashCode),
        getClass((Class (*)(B)) &__Object::getClass),
        toString((String (*)(B)) &__Object::toString),
        equals((bool (*)(B, Object)) &__Object::equals),
        m_B(&__B::m_B),
        m(&__B::m),
        m_A(&__B::m_A) {}
    };

    struct __Test042;
    struct __Test042_VT;
    typedef __Test042* Test042;
    
    struct __Test042 { 
      
      __Test042_VT* __vptr;
      
      __Test042();

      static void main_String(Test042,String);
      static Test042 __init();
      static Class __class();

      static __Test042_VT __vtable;
    };

    struct __Test042_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test042);
      Class (*getClass) (Test042);
      String (*toString) (Test042);
      bool (*equals) (Test042, Object);

      __Test042_VT()
      : __is_a(__Test042::__class()),
        hashCode((int32_t (*)(Test042)) &__Object::hashCode),
        getClass((Class (*)(Test042)) &__Object::getClass),
        toString((String (*)(Test042)) &__Object::toString),
        equals((bool (*)(Test042, Object)) &__Object::equals),
        main_String(&__Test042::main_String) {}
    };

  }
}
