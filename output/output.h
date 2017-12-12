#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test003 {
  
    struct __A;
    struct __A_VT;
    typedef __A* A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

      private String fld;

      static String getFld(A);
      static A __init(String);
      static Class __class();

      static __A_VT __vtable;
    };

    struct __A_VT { 
      Class __is_a;

      int32_t (*hashCode) (A);
      Class (*getClass) (A);
      String (*toString) (A);
      bool (*equals) (A, Object);
      String (*getFld) (A);

      __A_VT()
      : __is_a(__A::__class()),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        getClass((Class (*)(A)) &__Object::getClass),
        toString((String (*)(A)) &__Object::toString),
        equals((bool (*)(A, Object)) &__Object::equals),
        getFld(&__A::getFld) {}
    };

    struct __Test003;
    struct __Test003_VT;
    typedef __Test003* Test003;
    
    struct __Test003 { 
      
      __Test003_VT* __vptr;
      
      __Test003();

      static void main_String(Test003,String);
      static Test003 __init();
      static Class __class();

      static __Test003_VT __vtable;
    };

    struct __Test003_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test003);
      Class (*getClass) (Test003);
      String (*toString) (Test003);
      bool (*equals) (Test003, Object);

      __Test003_VT()
      : __is_a(__Test003::__class()),
        hashCode((int32_t (*)(Test003)) &__Object::hashCode),
        getClass((Class (*)(Test003)) &__Object::getClass),
        toString((String (*)(Test003)) &__Object::toString),
        equals((bool (*)(Test003, Object)) &__Object::equals),
        main_String(&__Test003::main_String) {}
    };

  }
}
