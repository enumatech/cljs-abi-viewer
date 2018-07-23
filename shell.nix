# curl -sI https://nixos.org/channels/nixpkgs-unstable/nixexprs.tar.xz | awk '/Location:/ {print $2}'
with import (builtins.fetchTarball "https://releases.nixos.org/nixpkgs/nixpkgs-18.09pre146471.d7d31fea7e7/nixexprs.tar.xz") {};

mkShell rec {
  buildInputs = [ clojure ];
}
