#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test038 {
  
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
      void (*m_Object_Object) (A, Object, Object);
      void (*m_A_Object) (A, A, Object);
      void (*m_Object_A) (A, Object, A);

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

      int32_t (*hashCode) (B);
      Class (*getClass) (B);
      String (*toString) (B);
      bool (*equals) (B, Object);
      void (*m_Object_Object) (B, Object, Object);
      void (*m_A_Object) (B, A, Object);
      void (*m_Object_A) (B, Object, A);
      void (*m_B_Object) (B, B, Object);
      void (*m_Object_B) (B, Object, B);

      __B_VT()
      : __is_a(__B::__class()),
        hashCode((int32_t (*)(B)) &__Object::hashCode),
        getClass((Class (*)(B)) &__Object::getClass),
        toString((String (*)(B)) &__Object::toString),
        equals((bool (*)(B, Object)) &__Object::equals),
        m_Object_Object(&__B::m_Object_Object),
        m_A_Object((void (*)(B)) &__A::m_A_Object),
        m_Object_A((void (*)(B)) &__A::m_Object_A),
        m_B_Object(&__B::m_B_Object),
        m_Object_B(&__B::m_Object_B) {}
    };

    struct __Test038;
    struct __Test038_VT;
    typedef __Test038* Test038;
    
    struct __Test038 { 
      
      __Test038_VT* __vptr;
      
      __Test038();

      static void main_String(Test038,String);
      static Test038 __init();
      static Class __class();

      static __Test038_VT __vtable;
    };

    struct __Test038_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test038);
      Class (*getClass) (Test038);
      String (*toString) (Test038);
      bool (*equals) (Test038, Object);
      void (*main_String) (Test038, String);

      __Test038_VT()
      : __is_a(__Test038::__class()),
        hashCode((int32_t (*)(Test038)) &__Object::hashCode),
        getClass((Class (*)(Test038)) &__Object::getClass),
        toString((String (*)(Test038)) &__Object::toString),
        equals((bool (*)(Test038, Object)) &__Object::equals),
        main_String(&__Test038::main_String) {}
    };

  }
}
