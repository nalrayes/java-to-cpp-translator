#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

<<<<<<< HEAD
using namespace inputs::test020;
=======
using namespace inputs::test030;
>>>>>>> 16778525e1a93051b24e450824e2cc3cd19cced5

int __A::x;
int main(int argc, char* argv[]) {
  __rt::Array<String> args = new __rt::__Array<String>(argc - 1);
  for (int32_t i = 1; i < argc; i++) {
    (*args)[i] = __rt::literal(argv[i]);
  }
<<<<<<< HEAD
  int x;
  x = __A::x;
  std::cout << __A::x_static() << std::endl;
=======
  __rt::Array<__rt::Array<A>> as =  new __rt::__Array<__rt::Array<A>>(5);
  __rt::Array<__rt::Array<A>> asking =  new __rt::__Array<__rt::Array<A>>(5);
  std::cout << ({Object tmp0 = ({__rt::checkNotNull(as); as->__vptr->getClass(as);}); __rt::checkNotNull(tmp0); __rt::checkNotNull(({__rt::checkNotNull(as); as->__vptr->getClass(as);})); ({__rt::checkNotNull(as); as->__vptr->getClass(as);})->__vptr->toString(({__rt::checkNotNull(as); as->__vptr->getClass(as);}));}) << std::endl;
>>>>>>> 16778525e1a93051b24e450824e2cc3cd19cced5
  return 0;
}
