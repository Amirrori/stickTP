# Introduction:
Teleport plugin for Paper servers. Right click with a magic stick to teleport onto the block you're looking at.

- Only the stick from `/magicstick` works, normal sticks do nothing.
- You land on top of the block, in the middle, facing the same way as before.
- No teleport into the sky, into walls or under low ceilings.
- Range of 100 blocks, 2 second cooldown.

## Requirements

- Server with at least Paper 1.20.1
- Java 17

# Usage

## Command

| Command | Description | Permission |
|---------|-------------|------------|
| `/magicstick` | Gives you a magic stick. | `sticktp.magicstick` |

## Permissions

| Permission | Description | Default |
|------------|-------------|---------|
| `sticktp.magicstick` | Allows `/magicstick`. | op |
| `sticktp.use` | Allows teleporting with the magic stick. | everyone |

# Setup

## JAR file
Drag and drop the jar file into your paper server's plugins directory.
Restart the server.

## Build from source

Clone the git repository.

Build using Maven:

Requirement: `maven`
```
cd /path/to/stickTP
mvn package
```
The jar ends up in `target/`.

# License

MIT, see [LICENSE](LICENSE).
