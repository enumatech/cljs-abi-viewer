# ClojureScript ABI Viewer

Prerequisite on both macOS and Linux:
- [Nix 2.0](https://nixos.org/nix/) package manager

## Start

```
nix-shell
clj -A:build-dev
```

## `resources/public/net/4/*.json`

Just some real-world ABI examples, taken from:
https://gitlab.com/oax/dex-poc/tree/master/dex/net/4

## `cljs.dom` namespace

It provides simple Clojure functions to wrap the verbose, imperative JS methods.

## The main namespace: `abi.viewer`

The main application which `figwheel` is going to refresh, along with the
styles in `./resources/public/app.css`.
