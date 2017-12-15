#pragma once
#include "java_lang.h"
#include <string>
#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace inputs::constructors;
using namespace namespace std;

namespace inputs {
  namespace test012 {

    __A::__A() : __vptr(&__vtable), a(null)
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
    
    void __A::setA_String(A __this, String x) {
      __this->a = x;
    }
    
    void __A::printOther_A(A __this, A other) {
      std::cout << other->__vptr->myToString(other) << std::endl;
    }
    
    String __A::myToString(A __this) {
      return __this->a;
    }
    
    __B1::__B1() : __vptr(&__vtable), b(null)
    {}

    Class __B1::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.B1"), __A::__class());
      return k;
    }

    __B1_VT __B1::__vtable;

    B1 __B1:: __init(B1__this) {
      return __this;
    }
    
    __B2::__B2() : __vptr(&__vtable), b(null)
    {}

    Class __B2::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.B2"), __A::__class());
      return k;
    }

    __B2_VT __B2::__vtable;

    B2 __B2:: __init(B2__this) {
      return __this;
    }
    
    __C::__C() : __vptr(&__vtable), c(null)
    {}

    Class __C::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.C"), __B1::__class());
      return k;
    }

    __C_VT __C::__vtable;

    C __C:: __init(C__this) {
      return __this;
    }
    
    String __C::myToString(C __this) {
      return __rt::literal("still C");
    }
    
  }
}
