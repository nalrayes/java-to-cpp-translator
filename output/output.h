#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test001 {
  
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

      int32_t (*hashCode) (A);
      Class (*getClass) (A);
      String (*toString) (A);
      bool (*equals) (A, Object);

      __A_VT()
      : __is_a(__A::__class()),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        getClass((Class (*)(A)) &__Object::getClass),
        toString(&__A::toString),
        equals((bool (*)(A, Object)) &__Object::equals) {}
    };

    struct __Test001;
    struct __Test001_VT;
    typedef __rt::Ptr<__Test001> Test001;
    
    struct __Test001 { 
      
      __rt::Ptr<__Test001_VT> __vptr;
      
      __Test001();

      static void main_String(Test001,String);
      static Test001 __init(A __this);
      static Class __class();

      static __Test001_VT __vtable;
    };

    struct __Test001_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test001);
      Class (*getClass) (Test001);
      String (*toString) (Test001);
      bool (*equals) (Test001, Object);
      void (*main_String) (Test001, String);

      __Test001_VT()
      : __is_a(__Test001::__class()),
        hashCode((int32_t (*)(Test001)) &__Object::hashCode),
        getClass((Class (*)(Test001)) &__Object::getClass),
        toString((String (*)(Test001)) &__Object::toString),
        equals((bool (*)(Test001, Object)) &__Object::equals),
        main_String(&__Test001::main_String) {}
    };

  }
}
