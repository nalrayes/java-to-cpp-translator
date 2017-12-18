#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

using namespace inputs::test010;

int main(int argc, char* argv[]) {
  __rt::Array<String> args = new __rt::__Array<String>(argc - 1);
  for (int32_t i = 1; i < argc; i++) {
    (*args)[i] = __rt::literal(argv[i]);
  }
  A a =  __A::__init(new __A);
  ({__rt::checkNotNull(a); a->__vptr->setA(a, __rt::literal("A"));});
  B1 b1 =  __B1::__init(new __B1);
  ({__rt::checkNotNull(b1); b1->__vptr->setA(b1, __rt::literal("B1"));});
  B2 b2 =  __B2::__init(new __B2);
  ({__rt::checkNotNull(b2); b2->__vptr->setA(b2, __rt::literal("B2"));});
  C c =  __C::__init(new __C);
  ({__rt::checkNotNull(c); c->__vptr->setA(c, __rt::literal("C"));});
  ({__rt::checkNotNull(a); a->__vptr->printOther(a, a);});
  ({__rt::checkNotNull(a); a->__vptr->printOther(a, b1);});
  ({__rt::checkNotNull(a); a->__vptr->printOther(a, b2);});
  ({__rt::checkNotNull(a); a->__vptr->printOther(a, c);});
  return 0;
}
