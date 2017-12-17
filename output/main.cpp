#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

using namespace inputs::test014;

int main(void) {
  A a =  __A::__init(new __A);
  A other = a->some;
  ({__rt::checkNotNull(a); a->__vptr->printOther_A(a, other);});
  return 0;
}
