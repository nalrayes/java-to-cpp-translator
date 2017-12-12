#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
<<<<<<< HEAD
  namespace test027 {
=======
  namespace test025 {
>>>>>>> 9fd0c2d51a8867caaa9f69ec9f8134e2ca2ea3a1
  
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

<<<<<<< HEAD
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
=======
    struct __B;
    struct __B_VT;
    typedef __B* B;
    
    struct __B { 
      
      __B_VT* __vptr;
      
      __B();

      static int32_t get(B);
      static B __init(int32_t);
      static Class __class();

      static __B_VT __vtable;
    };

    struct __B_VT { 
      Class __is_a;

      int32_t (*hashCode) (B);
      Class (*getClass) (B);
      String (*toString) (B);
      bool (*equals) (B, Object);
      int32_t (*get) (B);

      __B_VT()
      : __is_a(__B::__class()),
        hashCode((int32_t (*)(B)) &__Object::hashCode),
        getClass((Class (*)(B)) &__Object::getClass),
        toString((String (*)(B)) &__Object::toString),
        equals((bool (*)(B, Object)) &__Object::equals),
        get(&__B::get) {}
    };

    struct __Test025;
    struct __Test025_VT;
    typedef __Test025* Test025;
    
    struct __Test025 { 
      
      __Test025_VT* __vptr;
      
      __Test025();

      static void main_String(Test025,String);
      static Test025 __init();
      static Class __class();

      static __Test025_VT __vtable;
    };

    struct __Test025_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test025);
      Class (*getClass) (Test025);
      String (*toString) (Test025);
      bool (*equals) (Test025, Object);

      __Test025_VT()
      : __is_a(__Test025::__class()),
        hashCode((int32_t (*)(Test025)) &__Object::hashCode),
        getClass((Class (*)(Test025)) &__Object::getClass),
        toString((String (*)(Test025)) &__Object::toString),
        equals((bool (*)(Test025, Object)) &__Object::equals),
        main_String(&__Test025::main_String) {}
>>>>>>> 9fd0c2d51a8867caaa9f69ec9f8134e2ca2ea3a1
    };

  }
}
