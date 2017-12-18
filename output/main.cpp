#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

using namespace inputs::test025;

int main(int argc, char* argv[]) {
  __rt::Array<String> args = new __rt::__Array<String>(argc - 1);
  for (int32_t i = 1; i < argc; i++) {
    (*args)[i] = __rt::literal(argv[i]);
  }
  __rt::Array<Object> as =  new __rt::__Array<Object>(10);
  for (int32_t i = 0; i <({__rt::checkNotNull(as); as->length; }); i++) {
    (*as)[i] = __B::__init(new __B(), i);
  }
  int k = 0;
  while (k < 10) {
    std::cout << ({A tmpCast = __rt::java_cast<A>((*as)[k]);tmpCast->__vptr->get(tmpCast);}) << std::endl;
    k = k + 1;
  }
  return 0;
}
