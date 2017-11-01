#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test004 {
  
    struct __A;
    struct __A_VT;
    typedef __A* A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

      static String getFld(A);
      static A __init(String);
      String fld;

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

    struct __Test004;
    struct __Test004_VT;
    typedef __Test004* Test004;
    
    struct __Test004 { 
      
      __Test004_VT* __vptr;
      
      __Test004();

      static void main(Test004,String);
      static Test004 __init();
      static Class __class();

      static __Test004_VT __vtable;
    };

    struct __Test004_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test004);
      Class (*getClass) (Test004);
      String (*toString) (Test004);
      bool (*equals) (Test004, Object);
      void (*main) (Test004);

      __Test004_VT()
      : __is_a(__Test004::__class()),
        hashCode((int32_t (*)(Test004)) &__Object::hashCode),
        getClass((Class (*)(Test004)) &__Object::getClass),
        toString((String (*)(Test004)) &__Object::toString),
        equals((bool (*)(Test004, Object)) &__Object::equals),
        main(&__Test004::main) {}
    };

  }
}
