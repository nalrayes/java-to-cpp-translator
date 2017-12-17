#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

using namespace inputs::test005;

int main(void) {
  B b =  __B::__init(new __B));
  A a1 =  __A::__init(new __A));
  A a2 = b;
  std::cout << ({__rt::checkNotNull(a1); a1->__vptr->toString(a1);}) << std::endl;
  std::cout << ({__rt::checkNotNull(a2); a2->__vptr->toString(a2);}) << std::endl;
  return 0;
}
