#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

using namespace inputs::test023;

int main(int argc, char* argv[]) {
  __rt::Array<String> args = new __rt::__Array<String>(argc - 1);
  for (int32_t i = 1; i < argc; i++) {
    (*args)[i] = __rt::literal(argv[i]);
  }
  Object as = args;
  for (int i = 0; i < sizeof(*as)/sizeof((*as)[0]); i++) {
    std::cout << (*as)[i] << std::endl;
  }
  return 0;
}
