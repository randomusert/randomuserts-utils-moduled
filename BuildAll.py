
# We import some important stuff here.
import argparse
import os
import shutil
import subprocess
import sys


def run_cmd(cmd, cwd=None):
    try:
        print(f"> {' '.join(cmd)}")
        subprocess.run(cmd, check=True, cwd=cwd)
    except subprocess.CalledProcessError as e:
        print(f"[ERROR] Command failed: {' '.join(cmd)}")
        print(f"[ERROR] Return code: {e.returncode}")
        sys.exit(e.returncode)
    except FileNotFoundError as e:
        print(f"[ERROR] Command not found: {cmd[0]}")
        sys.exit(1)

# We build all of the modules
def build_all():
    if sys.platform.startswith('win32'):
        run_cmd("gradlew build")
    if sys.platform.startswith('linux'):
        run_cmd("./gradlew build")
    if sys.platform.startswith('darwin'):
        run_cmd("./gradlew build")

# We build all of the fabric modules
def build_fabric_all():
    if sys.platform.startswith('win32'):
        run_cmd("gradlew :fabric:build")
        run_cmd("gradlew :compat:build")
    if sys.platform.startswith('linux'):
        run_cmd("./gradlew :fabric:build")
        run_cmd("./gradlew :compat:build")
    if sys.platform.startswith('darwin'):
        run_cmd("./gradlew :fabric:build")
        run_cmd("./gradlew :compat:build")

def build_fabric():
    if sys.platform.startswith('win32'):
        run_cmd("gradlew :fabric:build")
    if sys.platform.startswith('linux'):
        run_cmd("./gradlew :fabric:build")
    if sys.platform.startswith('darwin'):
        run_cmd("./gradlew :fabric:build")

def build_compat_fabric():
    if sys.platform.startswith('win32'):
        run_cmd("gradlew :compat:build")
    if sys.platform.startswith('linux'):
        run_cmd("./gradlew :compat:build")
    if sys.platform.startswith('darwin'):
        run_cmd("./gradlew :compat:build")

def main():
    parser = argparse.ArgumentParser(description="Randomusert's Utils Builder")
    parser.add_argument("--build-all", action="store_true", help="Build All modules")
    parser.add_argument("--build-fabric-all", action="store_true", help="Build the Fabric modules")
    parser.add_argument("--build-compat", action="store_true", help="Build the compat module")
    parser.add_argument("--build-fabric", action="store_true", help="Build the main fabric module module")
    args = parser.parse_args()

    try:
        if args.build_all:
            build_all()
        if args.build_fabric_all:
            build_fabric_all()
        if args.build_compat:
            build_compat_fabric()
        if args.build_fabric:
            build_fabric()
        if not (args.build_all or
                args.build_fabric_all or
                args.build_compat or
                args.build_fabric):
            parser.print_help()
    except KeyboardInterrupt:
        print("\n[INFO] Interrupted by user.")
        sys.exit(0)

if __name__ == "__main__":
    main()