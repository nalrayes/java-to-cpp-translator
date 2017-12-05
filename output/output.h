#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test041 {
  
    struct __A;
    struct __A_VT;
    typedef __A* A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

      static void m_Object_Object(A,Object,Object);
      static void m_A_Object(A,A,Object);
      static void m_Object_A(A,Object,A);
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
      void (*m_Object_Object) (A);
      void (*m_A_Object) (A);
      void (*m_Object_A) (A);

      __A_VT()
      : __is_a(__A::__class()),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        getClass((Class (*)(A)) &__Object::getClass),
        toString((String (*)(A)) &__Object::toString),
        equals((bool (*)(A, Object)) &__Object::equals),
        m_Object_Object(&__A::m_Object_Object),
        m_A_Object(&__A::m_A_Object),
        m_Object_A(&__A::m_Object_A) {}
    };

    struct __B;
    struct __B_VT;
    typedef __B* B;
    
    struct __B { 
      
      __B_VT* __vptr;
      
      __B();

      static void m_Object_Object(B,Object,Object);
      static void m_B_Object(B,B,Object);
      static void m_Object_B(B,Object,B);
      static B __init();
      static Class __class();

      static __B_VT __vtable;
    };

    struct __B_VT { 
      Class __is_a;

      void (*m_A_Object) (B);
      void (*m_Object_A) (B);
      int32_t (*hashCode) (B);
      Class (*getClass) (B);
      String (*toString) (B);
      bool (*equals) (B, Object);
      void (*m_B_Object) (B);
      void (*m_Object_B) (B);
      void (*m_Object_Object) (B);

      __B_VT()
      : __is_a(__B::__class()),
        m_A_Object((void (*)(B)) &__A::m_A_Object),
        m_Object_A((void (*)(B)) &__A::m_Object_A),
        hashCode((int32_t (*)(B)) &__Object::hashCode),
        getClass((Class (*)(B)) &__Object::getClass),
        toString((String (*)(B)) &__Object::toString),
        equals((bool (*)(B, Object)) &__Object::equals),
        m_B_Object(&__B::m_B_Object),
        m_Object_B(&__B::m_Object_B),
        m_Object_Object(&__B::m_Object_Object) {}
    };

    struct __C;
    struct __C_VT;
    typedef __C* C;
    
    struct __C { 
      
      __C_VT* __vptr;
      
      __C();

      static void m_C_C(C,C,C);
      static C __init();
      static Class __class();

      static __C_VT __vtable;
    };

    struct __C_VT { 
      Class __is_a;

      void (*m_Object_Object) (C);
      void (*m_A_Object) (C);
      void (*m_Object_A) (C);
      int32_t (*hashCode) (C);
      Class (*getClass) (C);
      String (*toString) (C);
      bool (*equals) (C, Object);
      void (*m_C_C) (C);

      __C_VT()
      : __is_a(__C::__class()),
        m_Object_Object((void (*)(C)) &__A::m_Object_Object),
        m_A_Object((void (*)(C)) &__A::m_A_Object),
        m_Object_A((void (*)(C)) &__A::m_Object_A),
        hashCode((int32_t (*)(C)) &__Object::hashCode),
        getClass((Class (*)(C)) &__Object::getClass),
        toString((String (*)(C)) &__Object::toString),
        equals((bool (*)(C, Object)) &__Object::equals),
        m_C_C(&__C::m_C_C) {}
    };

    struct __Test041;
    struct __Test041_VT;
    typedef __Test041* Test041;
    
    struct __Test041 { 
      
      __Test041_VT* __vptr;
      
      __Test041();

      static void main_String(Test041,String);
      static Test041 __init();
      static Class __class();

      static __Test041_VT __vtable;
    };

    struct __Test041_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test041);
      Class (*getClass) (Test041);
      String (*toString) (Test041);
      bool (*equals) (Test041, Object);
      void (*main_String) (Test041);

      __Test041_VT()
      : __is_a(__Test041::__class()),
        hashCode((int32_t (*)(Test041)) &__Object::hashCode),
        getClass((Class (*)(Test041)) &__Object::getClass),
        toString((String (*)(Test041)) &__Object::toString),
        equals((bool (*)(Test041, Object)) &__Object::equals),
        main_String(&__Test041::main_String) {}
    };

  }
}
