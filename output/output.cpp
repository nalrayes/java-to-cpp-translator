#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

namespace inputs {
<<<<<<< HEAD
  namespace test020 {
=======
  namespace test030 {
>>>>>>> 16778525e1a93051b24e450824e2cc3cd19cced5

    __A::__A() : __vptr(&__vtable)
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
    int32_t __A::x_static() {
      return 4;
=======
    A __A::__init(A __this, int i) {
      __Object::__init((Object) __this);
      __this->i = i;
      return __this;
    }
    
    int32_t __A::get(A __this) {
      return __this->i;
>>>>>>> 16778525e1a93051b24e450824e2cc3cd19cced5
    }
    
  }
}
