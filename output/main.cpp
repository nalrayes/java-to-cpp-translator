#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

using namespace inputs::test024;

int main(void) {
  __rt::Ptr<Object, __rt::array_policy> as =  new A[10];
  String $var11 = "1";
  for (int i = 0; i < as.length; i++) {
    (*as)[i] = __A::__init(new __A(), , i);
  }
  int k = 0;
  while (k < 10) {
    std::cout << ({__rt::checkNotNull(__rt::java_cast<A>((*as)[k])); __rt::java_cast<A>((*as)[k])->__vptr->get(__rt::java_cast<A>((*as)[k]));}) << std::endl;
    k = k + 1;
  }
  return 0;
}
