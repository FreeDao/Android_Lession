// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Message.proto

package com.irelandken.chat.message;

public final class MessageProtos {
  private MessageProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface MessageOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required int32 type = 1;
    /**
     * <code>required int32 type = 1;</code>
     */
    boolean hasType();
    /**
     * <code>required int32 type = 1;</code>
     */
    int getType();

    // optional string from = 2;
    /**
     * <code>optional string from = 2;</code>
     */
    boolean hasFrom();
    /**
     * <code>optional string from = 2;</code>
     */
    java.lang.String getFrom();
    /**
     * <code>optional string from = 2;</code>
     */
    com.google.protobuf.ByteString
        getFromBytes();

    // optional string to = 3;
    /**
     * <code>optional string to = 3;</code>
     */
    boolean hasTo();
    /**
     * <code>optional string to = 3;</code>
     */
    java.lang.String getTo();
    /**
     * <code>optional string to = 3;</code>
     */
    com.google.protobuf.ByteString
        getToBytes();

    // optional string content = 4;
    /**
     * <code>optional string content = 4;</code>
     */
    boolean hasContent();
    /**
     * <code>optional string content = 4;</code>
     */
    java.lang.String getContent();
    /**
     * <code>optional string content = 4;</code>
     */
    com.google.protobuf.ByteString
        getContentBytes();
  }
  /**
   * Protobuf type {@code proto.Message}
   */
  public static final class Message extends
      com.google.protobuf.GeneratedMessage
      implements MessageOrBuilder {
    // Use Message.newBuilder() to construct.
    private Message(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private Message(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final Message defaultInstance;
    public static Message getDefaultInstance() {
      return defaultInstance;
    }

    public Message getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private Message(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              type_ = input.readInt32();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              from_ = input.readBytes();
              break;
            }
            case 26: {
              bitField0_ |= 0x00000004;
              to_ = input.readBytes();
              break;
            }
            case 34: {
              bitField0_ |= 0x00000008;
              content_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.irelandken.chat.message.MessageProtos.internal_static_proto_Message_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.irelandken.chat.message.MessageProtos.internal_static_proto_Message_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.irelandken.chat.message.MessageProtos.Message.class, com.irelandken.chat.message.MessageProtos.Message.Builder.class);
    }

    public static com.google.protobuf.Parser<Message> PARSER =
        new com.google.protobuf.AbstractParser<Message>() {
      public Message parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Message(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<Message> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required int32 type = 1;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int type_;
    /**
     * <code>required int32 type = 1;</code>
     */
    public boolean hasType() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int32 type = 1;</code>
     */
    public int getType() {
      return type_;
    }

    // optional string from = 2;
    public static final int FROM_FIELD_NUMBER = 2;
    private java.lang.Object from_;
    /**
     * <code>optional string from = 2;</code>
     */
    public boolean hasFrom() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional string from = 2;</code>
     */
    public java.lang.String getFrom() {
      java.lang.Object ref = from_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          from_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string from = 2;</code>
     */
    public com.google.protobuf.ByteString
        getFromBytes() {
      java.lang.Object ref = from_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        from_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // optional string to = 3;
    public static final int TO_FIELD_NUMBER = 3;
    private java.lang.Object to_;
    /**
     * <code>optional string to = 3;</code>
     */
    public boolean hasTo() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional string to = 3;</code>
     */
    public java.lang.String getTo() {
      java.lang.Object ref = to_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          to_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string to = 3;</code>
     */
    public com.google.protobuf.ByteString
        getToBytes() {
      java.lang.Object ref = to_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        to_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // optional string content = 4;
    public static final int CONTENT_FIELD_NUMBER = 4;
    private java.lang.Object content_;
    /**
     * <code>optional string content = 4;</code>
     */
    public boolean hasContent() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional string content = 4;</code>
     */
    public java.lang.String getContent() {
      java.lang.Object ref = content_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          content_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string content = 4;</code>
     */
    public com.google.protobuf.ByteString
        getContentBytes() {
      java.lang.Object ref = content_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        content_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private void initFields() {
      type_ = 0;
      from_ = "";
      to_ = "";
      content_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasType()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, type_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getFromBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeBytes(3, getToBytes());
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeBytes(4, getContentBytes());
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, type_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getFromBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(3, getToBytes());
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(4, getContentBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.irelandken.chat.message.MessageProtos.Message parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.irelandken.chat.message.MessageProtos.Message parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.irelandken.chat.message.MessageProtos.Message parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.irelandken.chat.message.MessageProtos.Message parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.irelandken.chat.message.MessageProtos.Message parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.irelandken.chat.message.MessageProtos.Message parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.irelandken.chat.message.MessageProtos.Message parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.irelandken.chat.message.MessageProtos.Message parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.irelandken.chat.message.MessageProtos.Message parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.irelandken.chat.message.MessageProtos.Message parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.irelandken.chat.message.MessageProtos.Message prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code proto.Message}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.irelandken.chat.message.MessageProtos.MessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.irelandken.chat.message.MessageProtos.internal_static_proto_Message_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.irelandken.chat.message.MessageProtos.internal_static_proto_Message_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.irelandken.chat.message.MessageProtos.Message.class, com.irelandken.chat.message.MessageProtos.Message.Builder.class);
      }

      // Construct using com.irelandken.chat.message.MessageProtos.Message.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        type_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        from_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        to_ = "";
        bitField0_ = (bitField0_ & ~0x00000004);
        content_ = "";
        bitField0_ = (bitField0_ & ~0x00000008);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.irelandken.chat.message.MessageProtos.internal_static_proto_Message_descriptor;
      }

      public com.irelandken.chat.message.MessageProtos.Message getDefaultInstanceForType() {
        return com.irelandken.chat.message.MessageProtos.Message.getDefaultInstance();
      }

      public com.irelandken.chat.message.MessageProtos.Message build() {
        com.irelandken.chat.message.MessageProtos.Message result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.irelandken.chat.message.MessageProtos.Message buildPartial() {
        com.irelandken.chat.message.MessageProtos.Message result = new com.irelandken.chat.message.MessageProtos.Message(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.type_ = type_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.from_ = from_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.to_ = to_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.content_ = content_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.irelandken.chat.message.MessageProtos.Message) {
          return mergeFrom((com.irelandken.chat.message.MessageProtos.Message)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.irelandken.chat.message.MessageProtos.Message other) {
        if (other == com.irelandken.chat.message.MessageProtos.Message.getDefaultInstance()) return this;
        if (other.hasType()) {
          setType(other.getType());
        }
        if (other.hasFrom()) {
          bitField0_ |= 0x00000002;
          from_ = other.from_;
          onChanged();
        }
        if (other.hasTo()) {
          bitField0_ |= 0x00000004;
          to_ = other.to_;
          onChanged();
        }
        if (other.hasContent()) {
          bitField0_ |= 0x00000008;
          content_ = other.content_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasType()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.irelandken.chat.message.MessageProtos.Message parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.irelandken.chat.message.MessageProtos.Message) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required int32 type = 1;
      private int type_ ;
      /**
       * <code>required int32 type = 1;</code>
       */
      public boolean hasType() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int32 type = 1;</code>
       */
      public int getType() {
        return type_;
      }
      /**
       * <code>required int32 type = 1;</code>
       */
      public Builder setType(int value) {
        bitField0_ |= 0x00000001;
        type_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 type = 1;</code>
       */
      public Builder clearType() {
        bitField0_ = (bitField0_ & ~0x00000001);
        type_ = 0;
        onChanged();
        return this;
      }

      // optional string from = 2;
      private java.lang.Object from_ = "";
      /**
       * <code>optional string from = 2;</code>
       */
      public boolean hasFrom() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional string from = 2;</code>
       */
      public java.lang.String getFrom() {
        java.lang.Object ref = from_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          from_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string from = 2;</code>
       */
      public com.google.protobuf.ByteString
          getFromBytes() {
        java.lang.Object ref = from_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          from_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string from = 2;</code>
       */
      public Builder setFrom(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        from_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string from = 2;</code>
       */
      public Builder clearFrom() {
        bitField0_ = (bitField0_ & ~0x00000002);
        from_ = getDefaultInstance().getFrom();
        onChanged();
        return this;
      }
      /**
       * <code>optional string from = 2;</code>
       */
      public Builder setFromBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        from_ = value;
        onChanged();
        return this;
      }

      // optional string to = 3;
      private java.lang.Object to_ = "";
      /**
       * <code>optional string to = 3;</code>
       */
      public boolean hasTo() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>optional string to = 3;</code>
       */
      public java.lang.String getTo() {
        java.lang.Object ref = to_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          to_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string to = 3;</code>
       */
      public com.google.protobuf.ByteString
          getToBytes() {
        java.lang.Object ref = to_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          to_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string to = 3;</code>
       */
      public Builder setTo(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        to_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string to = 3;</code>
       */
      public Builder clearTo() {
        bitField0_ = (bitField0_ & ~0x00000004);
        to_ = getDefaultInstance().getTo();
        onChanged();
        return this;
      }
      /**
       * <code>optional string to = 3;</code>
       */
      public Builder setToBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        to_ = value;
        onChanged();
        return this;
      }

      // optional string content = 4;
      private java.lang.Object content_ = "";
      /**
       * <code>optional string content = 4;</code>
       */
      public boolean hasContent() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>optional string content = 4;</code>
       */
      public java.lang.String getContent() {
        java.lang.Object ref = content_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          content_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string content = 4;</code>
       */
      public com.google.protobuf.ByteString
          getContentBytes() {
        java.lang.Object ref = content_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          content_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string content = 4;</code>
       */
      public Builder setContent(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        content_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string content = 4;</code>
       */
      public Builder clearContent() {
        bitField0_ = (bitField0_ & ~0x00000008);
        content_ = getDefaultInstance().getContent();
        onChanged();
        return this;
      }
      /**
       * <code>optional string content = 4;</code>
       */
      public Builder setContentBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        content_ = value;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:proto.Message)
    }

    static {
      defaultInstance = new Message(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:proto.Message)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_Message_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_proto_Message_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rMessage.proto\022\005proto\"B\n\007Message\022\014\n\004typ" +
      "e\030\001 \002(\005\022\014\n\004from\030\002 \001(\t\022\n\n\002to\030\003 \001(\t\022\017\n\007con" +
      "tent\030\004 \001(\tB,\n\033com.irelandken.chat.messag" +
      "eB\rMessageProtos"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_proto_Message_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_proto_Message_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_proto_Message_descriptor,
              new java.lang.String[] { "Type", "From", "To", "Content", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
