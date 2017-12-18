#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

using namespace inputs::test010;

int main(void) {
  A a =  __A::__init(new __A);
  ({__rt::checkNotNull(a); a->__vptr->setA_String(a, __rt::literal("A"));});
  B1 b1 =  __B1::__init(new __B1);
  ({__rt::checkNotNull(b1); b1->__vptr->setA_String(b1, __rt::literal("B1"));});
  B2 b2 =  __B2::__init(new __B2);
  ({__rt::checkNotNull(b2); b2->__vptr->setA_String(b2, __rt::literal("B2"));});
  C c =  __C::__init(new __C);
  ({__rt::checkNotNull(c); c->__vptr->setA_String(c, __rt::literal("C"));});
  ({__rt::checkNotNull(a); a->__vptr->printOther_A(a, a);});
  ({__rt::checkNotNull(a); a->__vptr->printOther_A(a, b1);});
  ({__rt::checkNotNull(a); a->__vptr->printOther_A(a, b2);});
  ({__rt::checkNotNull(a); a->__vptr->printOther_A(a, c);});
  return 0;
}
