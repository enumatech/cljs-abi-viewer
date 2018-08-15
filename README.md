# State-channel system state-history viewer

Prerequisite on both macOS and Linux:
- [Nix 2.0](https://nixos.org/nix/) package manager

## Start in simple, hot-reloading mode

```
nix-shell
npm install
clojure -A:dev
```

## Start using a ClojureScript network REPL with Cursive

```
clojure -A:repl
```

This starts a regular Clojure REPL on port 7888.
Then we should creatie a _Clojure REPL / Remote_ run configuration
(Ctrl-Option-R) in IntelliJ/Cursive and use the _Connect to server_ option
with _Host_ being `localhost` and _Port_ being 7888.

The _Use Leiningen REPL port_ option doesn't seem work, even if we do
`echo -n 7888 > .nrepl-port`, because it asks us to pick a project,
but after saving it, it forgets that setting (probably because there is
no `project.clj`?)

After connecting to this Clojure nREPL server, we can fire up a figwheel
monitored ClojureScript build configuration with `(start)` which is a shortcut
for `(start "dev")` as defined in `src/user.clj`.

This opens up a browser window to http://localhost:9500/, which then connects
back to this figwheel ClojureScript build process over websockets and listens
for file hot-reload requests and ClojureScript expression evaluation requests.

To be able to send ClojureScript expressions to this build process, which then
sends the compiled JavaScript code over websockets for execution in the
browser, we have to connect a figwheel REPL client to it using the
`(cljs-repl)` convenience function, also defined in `src/user.clj`.

Cursive's REPL somehow notices this connection and switches to `cljs` mode,
so it can resolve and syntax highlight symbols accordingly.

After this we are in the `cljs.user` namespace, but we probably want to
evaluate expressions in the context of our main application namespace,
so we should switch to it, by evaluating `(in-ns 'eth.explorer)` for example.

Once we have this in our REPL history, we can quickly retrieve it in future
sessions via the _Search REPL history Opt-Cmd-E_ and just type for example
some substring of the namespace name.

Another way to switch is open the file of the desired namespace and use
_Switch REPL NS to current file Shift-Cmd-N_.

A probably more convenient way of evaluating expressions is putting them
into a file and just sending them from there with the
_Send '(some expr...)' to REPL Shift-Cmd-P_, by standing within a parenthesised
expression.

Now if we put these ephemeral expressions into a file, which is under a source
root directory, then figwheel will reload it, so we should mark its namespace
symbol with the `^:figwheel-no-load` meta data.

Unfortunately figwheel will still recompile this file and complain about
syntax errors in it. So we might think, we should just move it outside of
the source root. That would stop figwheel from compiling it, but it would
also stop Cursive from being able to resolve symbols in it and help with
auto-completion...

As a workaround we can create a `scripts/dev.cljs` file and tell only to
Cursive that the `scripts/` directory is a source root or a test root.
No more unnecessary recompilations and reloads, but auto-complete is
available!

## Motivation

See under the
[README.md](https://github.com/enumatech/cljs-abi-viewer/blob/master/README.md)
in the `master` branch.

## The main `history.viewer` namespace

This is the main application which `figwheel` loads and refreshes automatically,
along with the styles in `./resources/public/app.css`.

You can use `Shift-Left` and  `Shift-Right` to navigate between application states.

## Example screenshot

![Example screenshot](example-screenshot.png)

## Unconditional cooperative payment sequence

![Unconditional cooperative payment sequence](unconditional-payment.svg)
