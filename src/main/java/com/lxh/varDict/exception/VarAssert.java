package com.lxh.varDict.exception;

import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @ClassName: VarAssert
 * @Description:
 * @Author: hexli
 * @Date: 2020-01-06 
 **/
public abstract class VarAssert {
  public VarAssert() {
  }

  public static void state(boolean expression, String message) throws VarException {
    if (!expression) {
      throw new VarException(message);
    }
  }

  public static void state(boolean expression, Supplier<String> messageSupplier) throws VarException {
    if (!expression) {
      throw new VarException(nullSafeGet(messageSupplier));
    }
  }

  /** @deprecated */
  @Deprecated
  public static void state(boolean expression) throws VarException {
    state(expression, "[Assertion failed] - this state invariant must be true");
  }

  public static void isTrue(boolean expression, String message) throws VarException {
    if (!expression) {
      throw new VarException(message);
    }
  }

  public static void isTrue(boolean expression, Supplier<String> messageSupplier) throws VarException {
    if (!expression) {
      throw new VarException(nullSafeGet(messageSupplier));
    }
  }

  /** @deprecated */
  @Deprecated
  public static void isTrue(boolean expression) throws VarException {
    isTrue(expression, "[Assertion failed] - this expression must be true");
  }

  public static void isNull(@Nullable Object object, String message) throws VarException {
    if (object != null) {
      throw new VarException(message);
    }
  }

  public static void isNull(@Nullable Object object, Supplier<String> messageSupplier) throws VarException {
    if (object != null) {
      throw new VarException(nullSafeGet(messageSupplier));
    }
  }

  /** @deprecated */
  @Deprecated
  public static void isNull(@Nullable Object object) throws VarException {
    isNull(object, "[Assertion failed] - the object argument must be null");
  }

  public static void notNull(@Nullable Object object, String message) throws VarException {
    if (object == null) {
      throw new VarException(message);
    }
  }

  public static void notNull(@Nullable Object object, Supplier<String> messageSupplier) throws VarException {
    if (object == null) {
      throw new VarException(nullSafeGet(messageSupplier));
    }
  }

  /** @deprecated */
  @Deprecated
  public static void notNull(@Nullable Object object) throws VarException {
    notNull(object, "[Assertion failed] - this argument is required; it must not be null");
  }

  public static void hasLength(@Nullable String text, String message) throws VarException {
    if (!StringUtils.hasLength(text)) {
      throw new VarException(message);
    }
  }

  public static void hasLength(@Nullable String text, Supplier<String> messageSupplier) throws VarException {
    if (!StringUtils.hasLength(text)) {
      throw new VarException(nullSafeGet(messageSupplier));
    }
  }

  /** @deprecated */
  @Deprecated
  public static void hasLength(@Nullable String text) throws VarException {
    hasLength(text, "[Assertion failed] - this String argument must have length; it must not be null or empty");
  }

  public static void hasText(@Nullable String text, String message) throws VarException {
    if (!StringUtils.hasText(text)) {
      throw new VarException(message);
    }
  }

  public static void hasText(@Nullable String text, Supplier<String> messageSupplier) throws VarException {
    if (!StringUtils.hasText(text)) {
      throw new VarException(nullSafeGet(messageSupplier));
    }
  }

  /** @deprecated */
  @Deprecated
  public static void hasText(@Nullable String text) throws VarException {
    hasText(text, "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank");
  }

  public static void doesNotContain(@Nullable String textToSearch, String substring, String message)
          throws VarException {
    if (StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring) && textToSearch.contains(substring)) {
      throw new VarException(message);
    }
  }

  public static void doesNotContain(@Nullable String textToSearch, String substring, Supplier<String> messageSupplier)
          throws VarException {
    if (StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring) && textToSearch.contains(substring)) {
      throw new VarException(nullSafeGet(messageSupplier));
    }
  }

  /** @deprecated */
  @Deprecated
  public static void doesNotContain(@Nullable String textToSearch, String substring) throws VarException {
    doesNotContain(textToSearch, substring, () -> {
      return "[Assertion failed] - this String argument must not contain the substring [" + substring + "]";
    });
  }

  public static void notEmpty(@Nullable Object[] array, String message) throws VarException {
    if (ObjectUtils.isEmpty(array)) {
      throw new VarException(message);
    }
  }

  public static void notEmpty(@Nullable Object[] array, Supplier<String> messageSupplier) throws VarException {
    if (ObjectUtils.isEmpty(array)) {
      throw new VarException(nullSafeGet(messageSupplier));
    }
  }

  /** @deprecated */
  @Deprecated
  public static void notEmpty(@Nullable Object[] array) throws VarException {
    notEmpty(array, "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
  }

  public static void noNullElements(@Nullable Object[] array, String message) throws VarException {
    if (array != null) {
      Object[] var2 = array;
      int var3 = array.length;

      for(int var4 = 0; var4 < var3; ++var4) {
        Object element = var2[var4];
        if (element == null) {
          throw new VarException(message);
        }
      }
    }

  }

  public static void noNullElements(@Nullable Object[] array, Supplier<String> messageSupplier) throws VarException {
    if (array != null) {
      Object[] var2 = array;
      int var3 = array.length;

      for(int var4 = 0; var4 < var3; ++var4) {
        Object element = var2[var4];
        if (element == null) {
          throw new VarException(nullSafeGet(messageSupplier));
        }
      }
    }

  }

  /** @deprecated */
  @Deprecated
  public static void noNullElements(@Nullable Object[] array) throws VarException {
    noNullElements(array, "[Assertion failed] - this array must not contain any null elements");
  }

  public static void notEmpty(@Nullable Collection<?> collection, String message) throws VarException {
    if (CollectionUtils.isEmpty(collection)) {
      throw new VarException(message);
    }
  }

  public static void notEmpty(@Nullable Collection<?> collection, Supplier<String> messageSupplier)
          throws VarException {
    if (CollectionUtils.isEmpty(collection)) {
      throw new VarException(nullSafeGet(messageSupplier));
    }
  }

  /** @deprecated */
  @Deprecated
  public static void notEmpty(@Nullable Collection<?> collection) throws VarException {
    notEmpty(collection, "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
  }

  public static void noNullElements(@Nullable Collection<?> collection, String message) throws VarException {
    if (collection != null) {
      Iterator var2 = collection.iterator();

      while(var2.hasNext()) {
        Object element = var2.next();
        if (element == null) {
          throw new VarException(message);
        }
      }
    }

  }

  public static void noNullElements(@Nullable Collection<?> collection, Supplier<String> messageSupplier)
          throws VarException {
    if (collection != null) {
      Iterator var2 = collection.iterator();

      while(var2.hasNext()) {
        Object element = var2.next();
        if (element == null) {
          throw new VarException(nullSafeGet(messageSupplier));
        }
      }
    }

  }

  public static void notEmpty(@Nullable Map<?, ?> map, String message) throws VarException {
    if (CollectionUtils.isEmpty(map)) {
      throw new VarException(message);
    }
  }

  public static void notEmpty(@Nullable Map<?, ?> map, Supplier<String> messageSupplier) throws VarException {
    if (CollectionUtils.isEmpty(map)) {
      throw new VarException(nullSafeGet(messageSupplier));
    }
  }

  /** @deprecated */
  @Deprecated
  public static void notEmpty(@Nullable Map<?, ?> map) throws VarException {
    notEmpty(map, "[Assertion failed] - this map must not be empty; it must contain at least one entry");
  }

  public static void isInstanceOf(Class<?> type, @Nullable Object obj, String message) throws VarException {
    notNull(type, (String)"Type to check against must not be null");
    if (!type.isInstance(obj)) {
      instanceCheckFailed(type, obj, message);
    }

  }

  public static void isInstanceOf(Class<?> type, @Nullable Object obj, Supplier<String> messageSupplier)
          throws VarException {
    notNull(type, (String)"Type to check against must not be null");
    if (!type.isInstance(obj)) {
      instanceCheckFailed(type, obj, nullSafeGet(messageSupplier));
    }

  }

  public static void isInstanceOf(Class<?> type, @Nullable Object obj) throws VarException {
    isInstanceOf(type, obj, "");
  }

  public static void isAssignable(Class<?> superType, @Nullable Class<?> subType, String message) throws VarException {
    notNull(superType, (String)"Super type to check against must not be null");
    if (subType == null || !superType.isAssignableFrom(subType)) {
      assignableCheckFailed(superType, subType, message);
    }

  }

  public static void isAssignable(Class<?> superType, @Nullable Class<?> subType, Supplier<String> messageSupplier)
          throws VarException {
    notNull(superType, (String)"Super type to check against must not be null");
    if (subType == null || !superType.isAssignableFrom(subType)) {
      assignableCheckFailed(superType, subType, nullSafeGet(messageSupplier));
    }

  }

  public static void isAssignable(Class<?> superType, Class<?> subType) throws VarException {
    isAssignable(superType, subType, "");
  }

  private static void instanceCheckFailed(Class<?> type, @Nullable Object obj, @Nullable String msg)
          throws VarException {
    String className = obj != null ? obj.getClass().getName() : "null";
    String result = "";
    boolean defaultMessage = true;
    if (StringUtils.hasLength(msg)) {
      if (endsWithSeparator(msg)) {
        result = msg + " ";
      } else {
        result = messageWithTypeName(msg, className);
        defaultMessage = false;
      }
    }

    if (defaultMessage) {
      result = result + "Object of class [" + className + "] must be an instance of " + type;
    }

    throw new VarException(result);
  }

  private static void assignableCheckFailed(Class<?> superType, @Nullable Class<?> subType, @Nullable String msg)
          throws VarException {
    String result = "";
    boolean defaultMessage = true;
    if (StringUtils.hasLength(msg)) {
      if (endsWithSeparator(msg)) {
        result = msg + " ";
      } else {
        result = messageWithTypeName(msg, subType);
        defaultMessage = false;
      }
    }

    if (defaultMessage) {
      result = result + subType + " is not assignable to " + superType;
    }

    throw new VarException(result);
  }

  private static boolean endsWithSeparator(String msg) {
    return msg.endsWith(":") || msg.endsWith(";") || msg.endsWith(",") || msg.endsWith(".");
  }

  private static String messageWithTypeName(String msg, @Nullable Object typeName) {
    return msg + (msg.endsWith(" ") ? "" : ": ") + typeName;
  }

  @Nullable
  private static String nullSafeGet(@Nullable Supplier<String> messageSupplier) {
    return messageSupplier != null ? (String)messageSupplier.get() : null;
  }
}
