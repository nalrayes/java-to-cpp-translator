#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test024 {
  
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

    struct __Test024;
    struct __Test024_VT;
    typedef __Test024* Test024;
    
    struct __Test024 { 
      
      __Test024_VT* __vptr;
      
      __Test024();

      static void main_String(Test024,String);
      static Test024 __init();
      static Class __class();

      static __Test024_VT __vtable;
    };

    struct __Test024_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test024);
      Class (*getClass) (Test024);
      String (*toString) (Test024);
      bool (*equals) (Test024, Object);

      __Test024_VT()
      : __is_a(__Test024::__class()),
        hashCode((int32_t (*)(Test024)) &__Object::hashCode),
        getClass((Class (*)(Test024)) &__Object::getClass),
        toString((String (*)(Test024)) &__Object::toString),
        equals((bool (*)(Test024, Object)) &__Object::equals),
        main_String(&__Test024::main_String) {}
    };

  }
}
