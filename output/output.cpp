#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

namespace inputs {
<<<<<<< HEAD
  namespace test010 {

    __A::__A() : __vptr(&__vtable), a(__rt::null())
=======
  namespace test014 {

    __A::__A() : __vptr(&__vtable), some(__rt::null())
>>>>>>> 36ee1741fe9486eddbb8956b4a692daff79ee824
    {}

    Class __A::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.A"), __Object::__class());
      return k;
    }

    __A_VT __A::__vtable;

    A __A::__init(A __this) {
      __Object::__init((Object) __this);
      return __this;
    }
    
<<<<<<< HEAD
    void __A::setA_String(A __this, String x) {
      __this->a = x;
    }
    
    void __A::printOther_A(A __this, A other) {
      std::cout << ({__rt::checkNotNull(other); other->__vptr->toString(other);}) << std::endl;
    }
    
    String __A::toString(A __this) {
      return __this->a;
    }
    
    __B1::__B1() : __vptr(&__vtable), b(__rt::null())
    {}

    Class __B1::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.B1"), __A::__class());
      return k;
    }

    __B1_VT __B1::__vtable;

    B1 __B1::__init(B1 __this) {
      __A::__init((A) __this);
      return __this;
    }
    
    __B2::__B2() : __vptr(&__vtable), b(__rt::null())
    {}

    Class __B2::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.B2"), __A::__class());
      return k;
    }

    __B2_VT __B2::__vtable;

    B2 __B2::__init(B2 __this) {
      __A::__init((A) __this);
      return __this;
    }
    
    __C::__C() : __vptr(&__vtable), c(__rt::null())
    {}

    Class __C::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.C"), __B1::__class());
      return k;
    }

    __C_VT __C::__vtable;

    C __C::__init(C __this) {
      __B1::__init((B1) __this);
      return __this;
=======
    void __A::printOther_A(A __this, A other) {
      std::cout << ({__rt::checkNotNull(other); other->__vptr->toString(other);}) << std::endl;
>>>>>>> 36ee1741fe9486eddbb8956b4a692daff79ee824
    }
    
  }
}
