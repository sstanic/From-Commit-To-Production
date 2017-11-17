#!/usr/bin/env bash

set -o errexit
set -o pipefail
set -o nounset

dir=$(cd -P -- "$(dirname -- "$0")" && pwd -P)
root="${dir}/.."

unsigned_apk="${root}/app/build/outputs/apk/app-fullConfig-release-unsigned.apk"
unsigned_aligned_apk="${root}/app/build/outputs/apk/app-fullConfig-release-unsigned-aligned.apk"
keystore="${HOME}/gadgeothek.keystore"
keystore_pass="${HOME}/keystore-pass"

version_code=$(git rev-list --all --count)

(cd "${root}"; ./gradlew -PversionCode=${version_code} clean assembleRelease)

apk_name="Gadgeothek"

echo "Creating APK with name: ${apk_name}."

signed_apk="${root}/app/build/outputs/apk/${apk_name}.apk"

zipalign -v 4 "${unsigned_apk}" "${unsigned_aligned_apk}"

apksigner sign --ks "${keystore}" --ks-pass file:"${keystore_pass}" --out "${signed_apk}" "${unsigned_aligned_apk}"