#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test002 {
  
    struct __A;
    struct __A_VT;
    typedef __rt::Ptr<__A> A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

      static String toString(A);
      static A __init(A __this);
      static Class __class();

      static __A_VT __vtable;
    };

    struct __A_VT { 
      Class __is_a;

      void (*__delete) (__A*);
      int32_t (*hashCode) (A);
      Class (*getClass) (A);
      String (*toString) (A);
      bool (*equals) (A, Object);

      __A_VT()
      : __is_a(__A::__class()),
        __delete(__rt::__delete<__A>),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        getClass((Class (*)(A)) &__Object::getClass),
        toString((String (*)(A)) &__A::toString),
        equals((bool (*)(A, Object)) &__Object::equals) {}
    };

    struct __Test002;
    struct __Test002_VT;
    typedef __rt::Ptr<__Test002> Test002;
    
    struct __Test002 { 
      
      __Test002_VT* __vptr;
      
      __Test002();

      static void main_String(Test002,String);
      static Test002 __init(Test002 __this);
      static Class __class();

      static __Test002_VT __vtable;
    };

    struct __Test002_VT { 
      Class __is_a;

      void (*__delete) (__Test002*);
      int32_t (*hashCode) (Test002);
      Class (*getClass) (Test002);
      String (*toString) (Test002);
      bool (*equals) (Test002, Object);
      void (*main_String) (Test002, String);

      __Test002_VT()
      : __is_a(__Test002::__class()),
        __delete(__rt::__delete<__Test002>),
        hashCode((int32_t (*)(Test002)) &__Object::hashCode),
        getClass((Class (*)(Test002)) &__Object::getClass),
        toString((String (*)(Test002)) &__Object::toString),
        equals((bool (*)(Test002, Object)) &__Object::equals),
        main_String(&__Test002::main_String) {}
    };

  }
}
