#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

namespace inputs {
  namespace test014 {

    __A::__A() : __vptr(&__vtable), some(__rt::null())
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
    
    void __A::printOther_A(A __this, A other) {
      std::cout << ({__rt::checkNotNull(other); other->__vptr->toString(other);}) << std::endl;
    }
    
  }
}
