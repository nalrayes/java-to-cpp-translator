#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

using namespace inputs::test017;

int main(void) {
  A a =  __A::__init(new __A,5);
  std::cout << ({Object tmp0 = ({__rt::checkNotNull(a); a->__vptr->self(a);}); __rt::checkNotNull(tmp0); tmp0->__vptr->toString(tmp0);}) << std::endl;
  return 0;
}
