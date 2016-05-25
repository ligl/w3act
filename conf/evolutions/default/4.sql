# --- !Ups

ALTER TABLE document ADD md_ark varchar(255);
ALTER TABLE document ADD d_ark varchar(255);
ALTER TABLE document ADD mets_d_ark varchar(255);

ALTER TABLE document ALTER COLUMN landing_page_url TYPE text;
ALTER TABLE document ALTER COLUMN document_url TYPE text;

ALTER TABLE watched_target ALTER COLUMN document_url_scheme TYPE text;
ALTER TABLE watched_target ALTER COLUMN login_page_url TYPE text;
ALTER TABLE watched_target ALTER COLUMN logout_url TYPE text;

INSERT INTO public.mail_template(
  id, created_at, name, ttype, subject, from_email, place_holders,
  text, updated_at)
VALUES (nextval('mail_template_seq'), clock_timestamp(), 'BL Acknowledgement', 'THANK_YOU_ONLINE_PERMISSION_FORM',
        'British Library UKWA Licence Received', 'web-archivist@bl.uk', 'URL',
        '1_BL_acknowledgement.txt', clock_timestamp());

INSERT INTO public.mail_template(
  id, created_at, name, ttype, subject, from_email, place_holders,
  text, updated_at)
VALUES (nextval('mail_template_seq'), clock_timestamp(), 'NLS Acknowledgement', 'THANK_YOU_ONLINE_PERMISSION_FORM',
        'British Library UKWA Licence Received', 'web-archivist@bl.uk', 'URL',
        '2_NLS_acknowledgement.txt', clock_timestamp());

INSERT INTO public.mail_template(
  id, created_at, name, ttype, subject, from_email, place_holders,
  text, updated_at)
VALUES (nextval('mail_template_seq'), clock_timestamp(), 'BL Open Access Permission Request (LD Content)',
        'PERMISSION_REQUEST', 'UK Web Archive', 'web-archivist@bl.uk', 'URL, LINK',
        '3_BL_LD_openAccess.txt', clock_timestamp());

INSERT INTO public.mail_template(
  id, created_at, name, ttype, subject, from_email, place_holders,
  text, updated_at)
VALUES (nextval('mail_template_seq'), clock_timestamp(), 'NLS Open Access Permission Request (LD Content)',
        'PERMISSION_REQUEST', 'UK Web Archive', 'web-archivist@bl.uk', 'URL, LINK',
        '4_NLS_LD_openAccess.txt', clock_timestamp());

INSERT INTO public.mail_template(
  id, created_at, name, ttype, subject, from_email, place_holders,
  text, updated_at)
VALUES (nextval('mail_template_seq'), clock_timestamp(), 'BL Permission to Harvest (non NPLD Content)',
        'PERMISSION_REQUEST', 'UK Web Archive', 'web-archivist@bl.uk', 'URL, LINK',
        '5_BL_nonUK_nonLD.txt', clock_timestamp());

INSERT INTO public.mail_template(
  id, created_at, name, ttype, subject, from_email, place_holders,
  text, updated_at)
VALUES (nextval('mail_template_seq'), clock_timestamp(), 'NLS Permission to Harvest (non NPLD Content)',
        'PERMISSION_REQUEST', 'UK Web Archive', 'web-archivist@bl.uk', 'URL, LINK',
        '6_NLS_nonUK_nonLD.txt', clock_timestamp());

ALTER TABLE public.crawl_permission RENAME COLUMN mailtemplate_id TO mailtemplate_permission_request_id;
ALTER TABLE public.crawl_permission ADD COLUMN mailtemplate_acknowledgement_id bigint;
ALTER TABLE public.crawl_permission ADD CONSTRAINT fk_crawl_permission_mailtemplate_acknowledgement FOREIGN KEY (mailtemplate_acknowledgement_id)
  REFERENCES public.mail_template (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION;

# --- !Downs

ALTER TABLE public.crawl_permission DROP CONSTRAINT fk_crawl_permission_mailtemplate_acknowledgement;
ALTER TABLE public.crawl_permission DROP mailtemplate_acknowledgement_id;
ALTER TABLE public.crawl_permission RENAME COLUMN mailtemplate_permission_request_id TO mailtemplate_id;

DELETE FROM public.mail_template
WHERE name IN (
  'BL Acknowledgement',
  'NLS Acknowledgement',
  'BL Open Access Permission Request (LD Content)',
  'NLS Open Access Permission Request (LD Content)',
  'BL Permission to Harvest (non NPLD Content)',
  'NLS Permission to Harvest (non NPLD Content)'
);

ALTER TABLE document DROP md_ark;
ALTER TABLE document DROP d_ark;
ALTER TABLE document DROP mets_d_ark;

ALTER TABLE document ALTER COLUMN landing_page_url TYPE varchar(255);
ALTER TABLE document ALTER COLUMN document_url TYPE varchar(255);

ALTER TABLE watched_target ALTER COLUMN document_url_scheme TYPE varchar(255);
ALTER TABLE watched_target ALTER COLUMN login_page_url TYPE varchar(255);
ALTER TABLE watched_target ALTER COLUMN logout_url TYPE varchar(255);
