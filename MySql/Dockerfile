FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=HARBOUR
ENV MYSQL_USER=djs
ENV MYSQL_PASSWORD=djs

EXPOSE 3306

# Copy sql files. They will be picked up and executed
ADD init.sql /docker-entrypoint-initdb.d
ADD measurements.sql /docker-entrypoint-initdb.d

# Backslash for splitting one line
HEALTHCHECK --start-period=5s --interval=30s --timeout=5s --retries=10 \
CMD mysqladmin ping -u root --password=$$MYSQL_ROOT_PASSWORD -h 127.0.0.1 || exit 1