#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test024 {
  
    struct __A;
    struct __A_VT;
    typedef __rt::Ptr<__A> A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

      int32_t i;

      static int32_t get(A);
      static A __init(A, int32_t);
      static A __init(A __this);
      static Class __class();

      static __A_VT __vtable;
    };

    struct __A_VT { 
      Class __is_a;

      void (*__delete) (__A*);
      int32_t (*hashCode) (A);
      bool (*equals) (A, Object);
      Class (*getClass) (A);
      String (*toString) (A);
      int32_t (*get) (A);

      __A_VT()
      : __is_a(__A::__class()),
        __delete(__rt::__delete<__A>),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        equals((bool (*)(A, Object)) &__Object::equals),
        getClass((Class (*)(A)) &__Object::getClass),
        toString((String (*)(A)) &__Object::toString),
        get(&__A::get) {}
    };

    struct __Test024;
    struct __Test024_VT;
    typedef __rt::Ptr<__Test024> Test024;
    
    struct __Test024 { 
      
      __Test024_VT* __vptr;
      
      __Test024();

      static void main_String(Test024, String);
      static Test024 __init(Test024 __this);
      static Class __class();

      static __Test024_VT __vtable;
    };

    struct __Test024_VT { 
      Class __is_a;

      void (*__delete) (__Test024*);
      int32_t (*hashCode) (Test024);
      bool (*equals) (Test024, Object);
      Class (*getClass) (Test024);
      String (*toString) (Test024);
      void (*main_String) (Test024, String);

      __Test024_VT()
      : __is_a(__Test024::__class()),
        __delete(__rt::__delete<__Test024>),
        hashCode((int32_t (*)(Test024)) &__Object::hashCode),
        equals((bool (*)(Test024, Object)) &__Object::equals),
        getClass((Class (*)(Test024)) &__Object::getClass),
        toString((String (*)(Test024)) &__Object::toString),
        main_String(&__Test024::main_String) {}
    };

  }
}
