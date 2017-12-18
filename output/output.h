#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test017 {
  
    struct __A;
    struct __A_VT;
    typedef __rt::Ptr<__A> A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

      A self;

      static A self(A);
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
      A (*self) (A);

      __A_VT()
      : __is_a(__A::__class()),
        __delete(__rt::__delete<__A>),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        equals((bool (*)(A, Object)) &__Object::equals),
        getClass((Class (*)(A)) &__Object::getClass),
        toString((String (*)(A)) &__Object::toString),
        self(&__A::self) {}
    };

    struct __Test017;
    struct __Test017_VT;
    typedef __rt::Ptr<__Test017> Test017;
    
    struct __Test017 { 
      
      __Test017_VT* __vptr;
      
      __Test017();

      static void main_String(Test017, String);
      static Test017 __init(Test017 __this);
      static Class __class();

      static __Test017_VT __vtable;
    };

    struct __Test017_VT { 
      Class __is_a;

      void (*__delete) (__Test017*);
      int32_t (*hashCode) (Test017);
      bool (*equals) (Test017, Object);
      Class (*getClass) (Test017);
      String (*toString) (Test017);
      void (*main_String) (Test017, String);

      __Test017_VT()
      : __is_a(__Test017::__class()),
        __delete(__rt::__delete<__Test017>),
        hashCode((int32_t (*)(Test017)) &__Object::hashCode),
        equals((bool (*)(Test017, Object)) &__Object::equals),
        getClass((Class (*)(Test017)) &__Object::getClass),
        toString((String (*)(Test017)) &__Object::toString),
        main_String(&__Test017::main_String) {}
    };

  }
}
