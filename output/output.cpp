#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

namespace inputs {
<<<<<<< HEAD
  namespace test006 {

    __A::__A() : __vptr(&__vtable), fld(__rt::null())
=======
  namespace test005 {

    __A::__A() : __vptr(&__vtable)
>>>>>>> 8c001fd88a280e6bc77ec4974377399f11358cdf
    {}

    Class __A::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.A"), __Object::__class());
      return k;
    }

    __A_VT __A::__vtable;

    A __A::__init(A __this) {
      __Object::__init((Object) __this);
<<<<<<< HEAD
      __this->fld = __rt::literal("A");
      return __this;
    }
    
    void __A::setFld_String(A __this, String f) {
      __this->fld = f;
    }
    
    void __A::almostSetFld_String(A __this, String f) {
      String fld;
      fld = f;
    }
    
    String __A::getFld(A __this) {
      return __this->fld;
=======
      return __this;
    }
    
    String __A::toString(A __this) {
      return __rt::literal("A");
    }
    
    __B::__B() : __vptr(&__vtable)
    {}

    Class __B::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.B"), __A::__class());
      return k;
    }

    __B_VT __B::__vtable;

    B __B::__init(B __this) {
      __A::__init((A) __this);
      return __this;
    }
    
    String __B::toString(B __this) {
      return __rt::literal("B");
>>>>>>> 8c001fd88a280e6bc77ec4974377399f11358cdf
    }
    
  }
}
