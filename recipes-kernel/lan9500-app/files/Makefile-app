TARGET=lan9500-app

all: $(TARGET)
  lan9500-app: cmd9500.o
  $(CC) $(CFLAGS) -o $@ $^

clean:
  rm -f $(OBJS) $(TARGET)
