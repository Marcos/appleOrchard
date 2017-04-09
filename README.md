# Apple orchard

Simle apllication to collect apples in an orchard

## Build

```console
$ mvn clean install
```

## Running

```console
$ mvn spring-boot:run
```

## Using

### Collect max number of apples in a orchard
```console
$ curl http://localhost:8080/rest/orchard/collect
```

### Collect max number of apples in a orchard using two magic tokens, that double the value of a square. Magic tokens can be used only twice.
```console
$ curl http://localhost:8080/rest/orchard/collect/token
```