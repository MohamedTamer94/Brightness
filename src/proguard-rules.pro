# Add any ProGuard configurations specific to this
# extension here.

-keep public class io.mohamed.brightness.Brightness {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'io/mohamed/brightness/repack'
-flattenpackagehierarchy
-dontpreverify
