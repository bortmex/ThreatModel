DROP TABLE IF EXISTS threat;
drop sequence IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 1;

CREATE TABLE threat
(
  id                                      INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name                                    VARCHAR NOT NULL,
  description                             VARCHAR NOT NULL,
  source_of_threat                        VARCHAR NOT NULL,
  the_object_of_the_impact                VARCHAR NOT NULL,
  breach_of_confidentiality               INTEGER,
  integrity_violation                     INTEGER,
  violation_of_availability               INTEGER,
  date_of_inclusion_of_threat_in_the_BND  TIMESTAMP,
  last_modified_date                      TIMESTAMP
);