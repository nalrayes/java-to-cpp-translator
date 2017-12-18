#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test003 {
  
    struct __A;
    struct __A_VT;
    typedef __rt::Ptr<__A> A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

       String fld;

      static String getFld(A);
      static A __init(A, String);
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
      String (*getFld) (A);

      __A_VT()
      : __is_a(__A::__class()),
        __delete(__rt::__delete<__A>),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        equals((bool (*)(A, Object)) &__Object::equals),
        getClass((Class (*)(A)) &__Object::getClass),
        toString((String (*)(A)) &__Object::toString),
        getFld(&__A::getFld) {}
    };

    struct __Test003;
    struct __Test003_VT;
    typedef __rt::Ptr<__Test003> Test003;
    
    struct __Test003 { 
      
      __Test003_VT* __vptr;
      
      __Test003();

      static void main_String(Test003, String);
      static Test003 __init(Test003 __this);
      static Class __class();

      static __Test003_VT __vtable;
    };

    struct __Test003_VT { 
      Class __is_a;

      void (*__delete) (__Test003*);
      int32_t (*hashCode) (Test003);
      bool (*equals) (Test003, Object);
      Class (*getClass) (Test003);
      String (*toString) (Test003);
      void (*main_String) (Test003, String);

      __Test003_VT()
      : __is_a(__Test003::__class()),
        __delete(__rt::__delete<__Test003>),
        hashCode((int32_t (*)(Test003)) &__Object::hashCode),
        equals((bool (*)(Test003, Object)) &__Object::equals),
        getClass((Class (*)(Test003)) &__Object::getClass),
        toString((String (*)(Test003)) &__Object::toString),
        main_String(&__Test003::main_String) {}
    };

  }
}
