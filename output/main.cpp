#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

<<<<<<< HEAD
using namespace inputs::test006;

int main(void) {
  A a =  __A::__init(new __A);
  ({__rt::checkNotNull(a); a->__vptr->almostSetFld(a, __rt::literal("B"));});
  std::cout << ({__rt::checkNotNull(a); a->__vptr->getFld(a);}) << std::endl;
  ({__rt::checkNotNull(a); a->__vptr->setFld(a, __rt::literal("B"));});
  std::cout << ({__rt::checkNotNull(a); a->__vptr->getFld(a);}) << std::endl;
=======
using namespace inputs::test005;

int main(void) {
  B b =  __B::__init(new __B);
  A a1 =  __A::__init(new __A);
  A a2 = b;
  std::cout << ({__rt::checkNotNull(a1); a1->__vptr->toString(a1);}) << std::endl;
  std::cout << ({__rt::checkNotNull(a2); a2->__vptr->toString(a2);}) << std::endl;
>>>>>>> 8c001fd88a280e6bc77ec4974377399f11358cdf
  return 0;
}
