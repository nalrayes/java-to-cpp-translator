#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test027 {
  
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

    struct __Test027;
    struct __Test027_VT;
    typedef __Test027* Test027;
    
    struct __Test027 { 
      
      __Test027_VT* __vptr;
      
      __Test027();

      static void main_String(Test027,String);
      static Test027 __init();
      static Class __class();

      static __Test027_VT __vtable;
    };

    struct __Test027_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test027);
      Class (*getClass) (Test027);
      String (*toString) (Test027);
      bool (*equals) (Test027, Object);

      __Test027_VT()
      : __is_a(__Test027::__class()),
        hashCode((int32_t (*)(Test027)) &__Object::hashCode),
        getClass((Class (*)(Test027)) &__Object::getClass),
        toString((String (*)(Test027)) &__Object::toString),
        equals((bool (*)(Test027, Object)) &__Object::equals),
        main_String(&__Test027::main_String) {}
    };

  }
}
