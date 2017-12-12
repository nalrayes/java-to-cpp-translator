#pragma once
#include "java_lang.h"
#include <string>
#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace inputs::constructors;
using namespace namespace std;

namespace inputs {
  namespace test042 {

    __A::__A() : __vptr(&__vtable)
    {}

    Class __A::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.A"), __Object::__class());
      return k;
    }

    __A_VT __A::__vtable;

    A __A:: __init(A__this) {
      return __this;
    }
    
    void __A::m(A __this) {
      std::cout << __rt::literal("A.m()") << std::endl;
    }
    
    A __A::m_A(A __this, A a) {
      std::cout << __rt::literal("A.m(A)") << std::endl;
      return a;
    }
    
    __B::__B() : __vptr(&__vtable)
    {}

    Class __B::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.B"), __A::__class());
      return k;
    }

    __B_VT __B::__vtable;

    B __B:: __init(B__this) {
      return __this;
    }
    
    void __B::m(B __this) {
      std::cout << __rt::literal("B.m()") << std::endl;
    }
    
    B __B::m_B(B __this, B b) {
      std::cout << __rt::literal("B.m(B)") << std::endl;
      return b;
    }
    
    A __B::m_A(B __this, A a) {
      std::cout << __rt::literal("B.m(A)") << std::endl;
      return a;
    }
    
  }
}
