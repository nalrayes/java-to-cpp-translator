#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test036 {
  
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

    struct __Test036;
    struct __Test036_VT;
    typedef __Test036* Test036;
    
    struct __Test036 { 
      
      __Test036_VT* __vptr;
      
      __Test036();

      static void main_String(Test036,String);
      static Test036 __init();
      static Class __class();

      static __Test036_VT __vtable;
    };

    struct __Test036_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test036);
      Class (*getClass) (Test036);
      String (*toString) (Test036);
      bool (*equals) (Test036, Object);

      __Test036_VT()
      : __is_a(__Test036::__class()),
        hashCode((int32_t (*)(Test036)) &__Object::hashCode),
        getClass((Class (*)(Test036)) &__Object::getClass),
        toString((String (*)(Test036)) &__Object::toString),
        equals((bool (*)(Test036, Object)) &__Object::equals),
        main_String(&__Test036::main_String) {}
    };

  }
}
